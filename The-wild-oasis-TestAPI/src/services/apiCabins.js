import supabase, { supabaseUrl } from "./supabase";
import baseURL from "./BaseUrl";

const API_URL = `${baseURL}/cabin`;

export async function getCabins() {
  const res = await fetch(`${baseURL}/cabins`);
  if (!res.ok) throw new Error("Cabin cannot be loaded");
  const data = await res.json();
  console.log(data.length)
  return data;
}

export async function createEditCabin(newCabin, id) {
  const hasImagePath = newCabin.image?.startsWith?.(supabaseUrl);

  const imageName = `${Math.random()}-${newCabin.image.name}`.replaceAll(
    "/",
    ""
  );
  const imagePath = hasImagePath
    ? newCabin.image
    : `${supabaseUrl}/storage/v1/object/public/cabin-images/${imageName}`;

  // 1. Create/edit cabin
  let query = supabase.from("cabins");

  // A) CREATE
  if (!id) query = query.insert([{ ...newCabin, image: imagePath }]);

  // B) EDIT
  if (id) query = query.update({ ...newCabin, image: imagePath }).eq("id", id);

  const { data, error } = await query.select().single();

  if (error) {
    console.error(error);
    throw new Error("Cabin could not be created");
  }

  // 2. Upload image
  if (hasImagePath) return data;

  const { error: storageError } = await supabase.storage
    .from("cabin-images")
    .upload(imageName, newCabin.image);

  // 3. Delete the cabin IF there was an error uplaoding image
  if (storageError) {
    await supabase.from("cabins").delete().eq("id", data.id);
    console.error(storageError);
    throw new Error(
      "Cabin image could not be uploaded and the cabin was not created"
    );
  }

  return data;
}

async function uploadImg(file) {
  const formData = new FormData();
  formData.append("file", file);
  const res = await fetch(`${API_URL}/uploadImg`, {
    method: "POST",
    body: formData,
  });
  if (!res.ok) throw new Error("Cannot upload Img");
  const data = await res.text();
  return data;
}

export async function createNewCabin(newCabin) {
  const fileImg = newCabin.image;
  const imagePath = await uploadImg(fileImg);
  const updateCabin = { ...newCabin, image: imagePath };
  const res = await fetch(`${API_URL}/new`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(updateCabin),
  });
  if (!res.ok) throw new Error("Failed to create new cabin");
  const data = await res.json();
  return data;
}

export async function updateCabin(newCabin, id) {
  const updateCabin = { ...newCabin, cabin_id: id };

  const res = await fetch(`${API_URL}/update`, {
    method: "PUT",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(updateCabin),
  });
  if (!res.ok) throw new Error("Failed to update cabin");
  const data = await res.json();
  return data;
}

export async function deleteCabin(id) {
  const res = await fetch(`${API_URL}/delete?id=${id}`, {
    method: "DELETE",
  });

  if (!res.ok) throw new Error("Cannot delete cabin");
  const data = await res.json();
  return data;
}
