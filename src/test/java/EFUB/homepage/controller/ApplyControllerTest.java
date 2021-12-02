package EFUB.homepage.controller;

import EFUB.homepage.dto.SaveDesignDto;
import EFUB.homepage.dto.SaveDevelopDto;
import EFUB.homepage.dto.SaveInterviewDto;
import EFUB.homepage.dto.SaveToolDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class ApplyControllerTest {
    @Autowired
    private ApplyController applyController;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    SaveDevelopDto createDevelop(){
        SaveToolDto tool1 = new SaveToolDto("Java");
        SaveToolDto tool2 = new SaveToolDto("SpringBoot");
        List<SaveToolDto> toolList = new ArrayList<>();
        toolList.add(tool1);
        toolList.add(tool2);

        SaveInterviewDto interview1 = new SaveInterviewDto("2021-12-02");
        SaveInterviewDto interview2 = new SaveInterviewDto("2021-12-03");
        List<SaveInterviewDto> interviewList = new ArrayList<>();
        interviewList.add(interview1);
        interviewList.add(interview2);

        SaveDevelopDto newDevelop = SaveDevelopDto.builder()
                .user_id(Long.valueOf(100))
                .motive("지원동기 테스트")
                .project_topic("하고싶은 주제 테스트")
                .application_field("리드개발자-테스트")
                .language("Java 테스트")
                .confidence_lang(4)
                .tool(toolList)
                .exp("경험 테스트")
                .link("http 테스트")
                .orientation(true)
                .interview(interviewList)
                .build();

        return newDevelop;
    }

    SaveDesignDto createDesign() {
        SaveToolDto tool1 = new SaveToolDto("포토샵");
        SaveToolDto tool2 = new SaveToolDto("일러스트레이터");
        List<SaveToolDto> toolList = new ArrayList<>();
        toolList.add(tool1);
        toolList.add(tool2);

        SaveDesignDto newDesign = SaveDesignDto.builder()
                .user_id(Long.valueOf(101))
                .motive("지원동기")
                .confidence_des(4)
                .tool(toolList)
                .confidence_tool(3)
                .project_topic("주제 테스트")
                .exp_des("디자이너 협업")
                .exp_dev("개발자 협업")
                .link("http://")
                .interview(true)
                .orientation(true)
                .build();

        return newDesign;
    }

    @Test
    void 개발자_저장() throws Exception {
        SaveDevelopDto newDevelop = createDevelop();

        mvc.perform(MockMvcRequestBuilders.post("/api/recruitment/apply/save/dev")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newDevelop)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void 디자이너_저장() throws Exception {
        SaveDesignDto newDesign = createDesign();

        mvc.perform(MockMvcRequestBuilders.post("/api/recruitment/apply/save/des")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newDesign)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void 최종_저장() throws Exception {
        SaveDevelopDto newDevelop = createDevelop();

        mvc.perform(MockMvcRequestBuilders.post("/api/recruitment/apply/save/dev")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newDevelop))
                .param("save_final", "true"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}