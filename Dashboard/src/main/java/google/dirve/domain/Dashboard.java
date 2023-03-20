package google.dirve.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String filename;
    private String size;
    private String type;
    private Boolean isindexed;
    private Boolean isUploaded;
    private String url;
}
