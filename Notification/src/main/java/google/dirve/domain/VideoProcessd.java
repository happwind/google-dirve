package google.dirve.domain;

import google.dirve.domain.*;
import google.dirve.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessd extends AbstractEvent {

    private Long id;
    private String fileid;
    private String url;
}
