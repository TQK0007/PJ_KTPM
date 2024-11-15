package com.example.the_wild_oasis.Service;
import com.example.the_wild_oasis.Model.Cabin;
import com.example.the_wild_oasis.repository.cabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CabinService {

    @Autowired
    private cabinRepository cabinRepository;
//    @Value("${ROOT_PATH}")
    private String ROOT_PATH = System.getProperty("user.dir").replace("\\","\\\\");

    public List<Cabin> getAll()
    {
        return cabinRepository.findAll();
    }

    public Optional<Cabin> findByID(int id)
    {
        return cabinRepository.findById(id);
    }

    public Optional<Cabin> findByName(String name)
    {
        return cabinRepository.findByName(name);
    }

    public List<Cabin> findByRangeRegularPrice(int min, int max)
    {
        return cabinRepository.findByRegularPriceBetween(min, max);
    }

    @Transactional
    public Cabin saveCabin(Cabin cabin) throws Exception
    {
        if(findByID(cabin.getCabin_id()).isPresent()) throw new RuntimeException("cabin_id already exists");
        if(cabin.getName() == null || cabin.getName().isEmpty()) throw new RuntimeException("Cabin name is required");
        if(cabin.getMaxCapacity() <=0 ) throw new RuntimeException("Max capacity must be greater than 0");
        if(cabin.getRegularPrice() <=0 ) throw new RuntimeException("Regular price must be greater than 0");
        if(cabin.getDiscount() >= cabin.getRegularPrice()) throw new RuntimeException("Discount must be less than regular price");
        if(cabin.getImage() == null || cabin.getImage().isEmpty()) throw new RuntimeException("Image is required");
        if(cabin.getDescription() == null || cabin.getDescription().isEmpty()) throw new RuntimeException("Description is required");
        return cabinRepository.save(cabin);
    }

    @Transactional
    public List<Cabin> saveAll(List<Cabin> cabins)
    {
        return cabinRepository.saveAll(cabins);
    }
    @Transactional
    public Cabin updateCabin(Cabin cabin) throws Exception{
        if(!findByID(cabin.getCabin_id()).isPresent()) throw new RuntimeException("not found cabin");
        if(cabin.getName() == null || cabin.getName().isEmpty()) throw new RuntimeException("Cabin name is required");
        if(cabin.getMaxCapacity() <=0 ) throw new RuntimeException("Max capacity must be greater than 0");
        if(cabin.getRegularPrice() <=0 ) throw new RuntimeException("Regular price must be greater than 0");
        if(cabin.getDiscount() >= cabin.getRegularPrice()) throw new RuntimeException("Discount must be less than regular price");
        if(cabin.getImage() == null || cabin.getImage().isEmpty()) throw new RuntimeException("Image is required");
        if(cabin.getDescription() == null || cabin.getDescription().isEmpty()) throw new RuntimeException("Description is required");
        return cabinRepository.save(cabin);
    }

    @Transactional
    public void deleteCabinByID(int id) throws Exception {
        if (!findByID(id).isPresent()) throw new RuntimeException("not found cabin");
        cabinRepository.deleteById(id);
    }

    @Transactional
    public int updateImgByID(String img, int id)
    {
        if(!findByID(id).isPresent()) return 0;
        cabinRepository.updateImgByID(img,id);
        return 1;
    }

    public ResponseEntity<String> uploadImg(MultipartFile file)
    {
        String rootURL = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        // Kiểm tra xem tệp có rỗng không
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        // Tạo tên tệp ngẫu nhiên
//       Kiểm tra loại tệp
        String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if(!fileExtension.matches("jpg|jpeg|png")) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Just upload file jpg, jpeg and png");


        // Đặt tên tệp duy nhất
        String fileName = UUID.randomUUID().toString()+"."+fileExtension;
//        String filePath = UPLOAD_DIR+File.separator+fileName;
        String filePath = ROOT_PATH+"\\src\\main\\resources\\static\\Img"+ File.separator+fileName;

        // Lưu tệp vào thư mục
        try
        {
            // tạo đường dẫn nếu chưa tồn tại
//            Files.createDirectories(Paths.get(UPLOAD_DIR));
            file.transferTo(new File(filePath));
        }
        catch (IOException e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
        return ResponseEntity.ok(rootURL+"/Img/"+fileName);
    }
}
