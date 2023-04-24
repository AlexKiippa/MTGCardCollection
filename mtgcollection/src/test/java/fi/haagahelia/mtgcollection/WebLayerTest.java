package fi.haagahelia.mtgcollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.CoreMatchers.containsString;

import fi.haagahelia.mtgcollection.web.MtgcollectionController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {
	
 @Autowired
 private MockMvc mockMvc;
 
 @Autowired
 private MtgcollectionController controller;
 
 @Test
 public void SeeifLoginpagehasString() throws Exception {
	 this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
	 .andExpect(content().string(containsString("Login page")));
	 }
}