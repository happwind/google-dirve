package google.dirve.infra;

import google.dirve.domain.*;
import google.dirve.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1 (@Payload FileUploaded fileUploaded) {
        try {

            if (!fileUploaded.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setId(fileUploaded.getId());
            dashboard.setFilename(fileUploaded.getFilename());
            dashboard.setSize(String.valueOf(fileUploaded.getSize()));
            dashboard.setType(FileUploaded.type);
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회

                List<Dashboard> dashboardList = dashboardRepository.findBy();
                for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setUrl(.getFileid());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

