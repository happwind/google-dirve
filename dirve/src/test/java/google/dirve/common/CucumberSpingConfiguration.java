package google.dirve.common;

import google.dirve.DirveApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DirveApplication.class })
public class CucumberSpingConfiguration {}
