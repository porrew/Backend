package sit.int204.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sit.int204.service.FilesStorageService;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class PracticeApplication  implements CommandLineRunner {
	
	@Resource
	FilesStorageService storageService;

	
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
	
	@Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
}
