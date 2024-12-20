package com.example.the_wild_oasis.Service.CabinServiceTest;

import com.example.the_wild_oasis.Model.Cabin;
import com.example.the_wild_oasis.Service.CabinService;
import com.example.the_wild_oasis.repository.cabinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//Khởi tạo các bean khi chạy test
@SpringBootTest
class saveCabinTest {

    //    kết nối đến lớp CabinService
    @Autowired

    private CabinService cabinService;

    //    giả lập kết nối csdl
    @MockBean

    private cabinRepository cabinRepository;

//    giả lập tm thấy cabin
    Cabin createCabinExists(int id)
    {
        Cabin cabin = new Cabin();
        cabin.setCabin_id(id);
        cabin.setName("001");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(1);
        cabin.setDiscount(0);
        cabin.setImage("image");
        cabin.setDescription("description");
        return cabin;
    }


    @Test
    void cabinExists() {
        int id =3 ;
        Cabin cabinExists = createCabinExists(2);

//        giả lập dữ liệu thêm vào
        Cabin cabin = new Cabin();
        cabin.setCabin_id(id);
        cabin.setName("009");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(1);
        cabin.setDiscount(0);
        cabin.setImage("image");
        cabin.setDescription("description");

        when(cabinRepository.findById(id)).thenReturn(Optional.of(cabinExists));
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("cabin_id already exists", e.getMessage());
    }

    @Test
    void cabinNameRequired() {
        Cabin cabin = new Cabin();
        cabin.setName(null);
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("Cabin name is required", e.getMessage());
    }

    @Test
    void maxCapacityLessMustGreaterThanZero() {
        Cabin cabin = new Cabin();
        cabin.setName("009");
        cabin.setMaxCapacity(0);
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("Max capacity must be greater than 0", e.getMessage());
    }

    @Test
    void regularPriceMustGreaterThanZero() {
        Cabin cabin = new Cabin();
        cabin.setName("009");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(0);
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("Regular price must be greater than 0", e.getMessage());
    }

    @Test
    void discountMustLessThanRegularPrice() {
        Cabin cabin = new Cabin();
        cabin.setName("009");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(1);
        cabin.setDiscount(2);
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("Discount must be less than regular price", e.getMessage());
    }

    @Test
    void imageRequired() {
        Cabin cabin = new Cabin();
        cabin.setName("009");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(1);
        cabin.setDiscount(0);
        cabin.setImage(null);
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("Image is required", e.getMessage());
    }

    @Test
    void descriptionRequired() {
        Cabin cabin = new Cabin();
        cabin.setName("009");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(1);
        cabin.setDiscount(0);
        cabin.setImage("image");
        cabin.setDescription(null);
        RuntimeException e = assertThrows(RuntimeException.class, () -> cabinService.saveCabin(cabin));
        assertEquals("Description is required", e.getMessage());
    }

    @Test
    void saveCabinSuccess() throws Exception {
        Cabin cabin = new Cabin();
        cabin.setName("009");
        cabin.setMaxCapacity(1);
        cabin.setRegularPrice(1);
        cabin.setDiscount(0);
        cabin.setImage("image");
        cabin.setDescription("description");
        when(cabinRepository.save(cabin)).thenReturn(cabin);
        Cabin saveCabin = cabinService.saveCabin(cabin);
        assertEquals(cabin,saveCabin);
    }
}