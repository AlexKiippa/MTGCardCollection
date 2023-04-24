package fi.haagahelia.mtgcollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.haagahelia.mtgcollection.web.MtgcollectionController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MtgcollectionApplicationTests {
	
	
	 @Autowired
	 private MtgcollectionController controller;
	 

	 @Test
	 public void contextLoads() throws Exception {
	 assertThat(controller).isNotNull();
	 }

}
