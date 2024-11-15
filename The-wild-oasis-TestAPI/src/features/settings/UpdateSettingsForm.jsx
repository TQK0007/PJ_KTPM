import Form from "../../ui/Form";
import FormRow from "../../ui/FormRow";
import Input from "../../ui/Input";
import Spinner from "../../ui/Spinner";
import { useSettings } from "./useSettings";
import { useUpdateSetting } from "./useUpdateSetting";

function UpdateSettingsForm() {
  const { isLoading, settings } = useSettings();

  const { isUpdating, updateSetting } = useUpdateSetting();

  if (isLoading) return <Spinner />;

  const {
    minBookingsLength,
    maxBookingsLength,
    maxGuestsPerBookings,
    breakfastPrice,
  } = settings;

  function handleUpdate(e, field) {
    const { value } = e.target;
    console.log(value);

    if (!value) return;
    updateSetting({ ...settings, [field]: value });
  }

  return (
    <Form>
      <FormRow label="Minimum nights/booking">
        <Input
          type="number"
          id="min-nights"
          defaultValue={minBookingsLength}
          disabled={isUpdating}
          onBlur={(e) => handleUpdate(e, "minBookingsLength")}
        />
      </FormRow>

      <FormRow label="Maximum nights/booking">
        <Input
          type="number"
          id="max-nights"
          defaultValue={maxBookingsLength}
          disabled={isUpdating}
          onBlur={(e) => handleUpdate(e, "maxBookingsLength")}
        />
      </FormRow>

      <FormRow label="Maximum guests/booking">
        <Input
          type="number"
          id="max-guests"
          defaultValue={maxGuestsPerBookings}
          disabled={isUpdating}
          onBlur={(e) => handleUpdate(e, "maxGuestsPerBookings")}
        />
      </FormRow>

      <FormRow label="Breakfast price">
        <Input
          type="number"
          id="breakfast-price"
          defaultValue={breakfastPrice}
          disabled={isUpdating}
          onBlur={(e) => handleUpdate(e, "breakfastPrice")}
        />
      </FormRow>
    </Form>
  );
}

export default UpdateSettingsForm;
