import supabase from "./supabase";
import baseURL from "./BaseUrl";

const API_URL = `${baseURL}/setting`;

export async function getSettings() {
  const res = await fetch(`${baseURL}/setting/find`);
  if (!res.ok) throw new Error("Settings cannot be loaded");
  const data = await res.json();
  return data;
}

// We expect a newSetting object that looks like {setting: newValue}
// export async function updateSetting(newSetting) {
//   const { data, error } = await supabase
//     .from("settings")
//     .update(newSetting)
//     // There is only ONE row of settings, and it has the ID=1, and so this is the updated one
//     .eq("id", 1)
//     .single();

//   if (error) {
//     console.error(error);
//     throw new Error("Settings could not be updated");
//   }

//   console.log(newSetting);

//   return data;
// }

export async function updateSetting(newSetting) {

  console.log(newSetting);

  const res = await fetch(`${API_URL}/update`, {
    method: "PUT",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(newSetting),
  });

  if (!res.ok) throw new Error("Failed to update new settings");

  const data = await res.json();
  console.log(data);
  return data;
}
