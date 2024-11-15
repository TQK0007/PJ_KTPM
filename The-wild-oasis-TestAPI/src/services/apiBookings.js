import { getToday } from "../utils/helpers";
import supabase from "./supabase";
import baseURL from "./BaseUrl";

// const API_URL = `${baseURL}/booking`;

export async function getBookings({ filter, sortBy, page }) {
  let res, data, count;

  // if(filter)
  // {
  //   console.log("filter")
  //   res = await fetch(`${baseURL}/bookingsDTOStatus?${filter.field}=${filter.value}&page=${page}`)
  //   if(filter.value !== "all")
  //   { 
  //     count = await getCountBookingsByStatus(filter.value);
  //   }
  //   else
  //   {
  //     count = await getCountBookings();
  //   }
  // }

  // if(sortBy)
  // {
  //   console.log("sort by")
  //     res = await fetch(`${baseURL}/bookingsDTOSort?sortBy=${sortBy.field}-${sortBy.direction}&page=${page}`)
  //     count = await getCountBookings();
  // }

  if(filter && sortBy )
  {
    console.log("filter-sort")
    console.log(sortBy)
    res = await fetch(`${baseURL}/bookingsDTOSortAndStatus?${filter.field}=${filter.value}&page=${page}&sortBy=${sortBy.field}-${sortBy.direction}`)
    
    if(filter.value !== "all")
    {
      count = await getCountBookingsByStatus(filter.value); 
    }
    else
    {
      count = await getCountBookings();
    }
  }

  else
  {
    console.log("page")
    res = await fetch(`${baseURL}/bookingsDTOPerPage?page=${page}`);
    count = await getCountBookings();
  }

  if (!res.ok) throw new Error("Bookings could not be loaded");
  data = await res.json();
  return {data, count};

}

async function getCountBookings() {
  const res = await fetch(`${baseURL}/bookingsDTOCount`);
  if (!res.ok) throw new Error("Bookings could not be loaded");
  const data = await res.text();
  return Number(data);
}

async function getCountBookingsByStatus(status) {
  const res = await fetch(`${baseURL}/bookingsDTOCountByStatus?status=${status}`);
  if (!res.ok) throw new Error("Bookings could not be loaded");
  const data = await res.text();
  return Number(data);
}



export async function getBooking(id) {
  const res = await fetch(`${baseURL}/bookingsDTOById?id=${id}`);
  if(!res.ok) throw new Error("Not found booking")
  const object = await res.json();
  return object.data;
}

// Returns all BOOKINGS that are were created after the given date. Useful to get bookings created in the last 30 days, for example.
export async function getBookingsAfterDate(date) {
  const { data, error } = await supabase
    .from("bookings")
    .select("created_at, totalPrice, extrasPrice")
    .gte("created_at", date)
    .lte("created_at", getToday({ end: true }));

  if (error) {
    console.error(error);
    throw new Error("Bookings could not get loaded");
  }

  return data;
}

// Returns all STAYS that are were created after the given date
export async function getStaysAfterDate(date) {
  const { data, error } = await supabase
    .from("bookings")
    // .select('*')
    .select("*, guests(fullName)")
    .gte("startDate", date)
    .lte("startDate", getToday());

  if (error) {
    console.error(error);
    throw new Error("Bookings could not get loaded");
  }

  return data;
}

// Activity means that there is a check in or a check out today
export async function getStaysTodayActivity() {
  const { data, error } = await supabase
    .from("bookings")
    .select("*, guests(fullName, nationality, countryFlag)")
    .or(
      `and(status.eq.unconfirmed,startDate.eq.${getToday()}),and(status.eq.checked-in,endDate.eq.${getToday()})`
    )
    .order("created_at");

  // Equivalent to this. But by querying this, we only download the data we actually need, otherwise we would need ALL bookings ever created
  // (stay.status === 'unconfirmed' && isToday(new Date(stay.startDate))) ||
  // (stay.status === 'checked-in' && isToday(new Date(stay.endDate)))

  if (error) {
    console.error(error);
    throw new Error("Bookings could not get loaded");
  }
  return data;
}

export async function updateBooking(id, obj) {
  const res = await fetch(`${baseURL}/updateBooking?id=${id}`,{
    method: "PATCH",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(obj)
  })
  if(!res.ok) throw new Error("Failed to update booking");
  const object = await res.json();
  return object.data; 
}

export async function deleteBooking(id) {
  const res = await fetch(`${baseURL}/deleteBooking?id=${id}`,{
    method: "DELETE"
  })
  if(!res.ok) throw new Error("Faild to delete booking")
  const obj = await res.json();
  return obj.data;
}
