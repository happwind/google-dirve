package google.dirve.domain;

import google.dirve.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String filename;
    private String url;
    private String path;
    private String type;
    private Long size;
    private String fileid;
}
