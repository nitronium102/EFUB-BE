package EFUB.homepage.service;

import EFUB.homepage.repository.DesignRepository;
import EFUB.homepage.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DesignService {
    private final DesignRepository designRepository;
    private final ToolRepository toolRepository;

//    @Transactional
//    public boolean checkByUserId(Long userId){
//        if(designRepository.findByUserId(userId).isEmpty()){
//            return false;
//        }
//        return true;
//    }

//    @Transactional
//    public Design save(DesignDto designDto){
//        return designRepository.save(designDto.toEntity());
//    }
//
//    @Transactional
//    public boolean update(UpdateDesignDto updateDesignDto){
//        Long desId = updateDesignDto.getDes_id();
//        Optional<Design> designOp = designRepository.findById(desId);
//        if(designOp.isEmpty()){
//            return false;
//        }
//        Design design = designOp.get();
//        design.update(updateDesignDto.getMotive(),
//                updateDesignDto.getConfidence_des(),
//                updateDesignDto.getConfidence_tool(),
//                updateDesignDto.getProject_topic(),
//                updateDesignDto.getExp_des(),
//                updateDesignDto.getExp_dev(),
//                updateDesignDto.getLink(),
//                updateDesignDto.getInterview(),
//                updateDesignDto.getOrientation());
//        return true;
//    }
//
//    @Transactional(readOnly = true)
//	public DesignResDto getDesign(Long user_id) {
//        Optional<Design> design = designRepository.findByUserId(user_id);
//        if (design.isEmpty())
//            return (new Design()).toDesignResDto(null);
//
//        List<ToolResDto> tools = toolRepository.findByUserId(user_id)
//            .stream().map(Tool::toToolResDto).collect(Collectors.toList());
//        return design.get().toDesignResDto(tools);
//	}
}
