package com.weblaptop.backend.services.Implements;
import com.weblaptop.backend.services.interfaces.IDemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService implements IDemoService {

//    @Autowired
//    private DemoRepository DemoRepository;

//    @Override
//    public ResponseEntity<Map<String, Object>> createDemo(demoModel demoModel) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<Map<String, Object>> getAllDemo() {
//       try {
//           List<DemoEntity> demoModelList= DemoRepository.findAll();
//           Map<String,Object> response=new HashMap<>();
//           response.put("Demos",demoModelList);
//           return new ResponseEntity<>(response, HttpStatus.OK);
//       }catch (Exception e){
//           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//       }
//
//    }


    @Transactional
    public String getAlldemo() {
        return "demo";
    }
}
