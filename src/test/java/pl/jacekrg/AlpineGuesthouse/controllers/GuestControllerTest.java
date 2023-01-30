package pl.jacekrg.AlpineGuesthouse.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import pl.jacekrg.AlpineGuesthouse.controllers.dto.GuestCreationDTO;
import pl.jacekrg.AlpineGuesthouse.domain.guest.Gender;
import pl.jacekrg.AlpineGuesthouse.domain.guest.Guest;
import pl.jacekrg.AlpineGuesthouse.domain.guest.GuestService;

import java.time.LocalDate;
import java.util.Arrays;

@WebMvcTest(GuestController.class)
public class GuestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    @Test
    public void basic() throws Exception {

        Guest guest = new Guest("Paweł", "Cwik", LocalDate.of(1986, 11, 13), Gender.MALE);

        Mockito.when(guestService.findAll()).thenReturn(Arrays.asList(guest));

        mockMvc.perform(get("/guests"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("guests"))
                .andExpect(view().name("guests"))
                .andExpect(content().string(containsString("1986-11-13")));
    }

    @Test
    public void handlePost() throws Exception {

        String postContent = "firstName=Pawel&lastName=Cwik&dateOfBirth=2021-09-15&gender=FEMALE";

        MockHttpServletRequestBuilder request =
                post("/guests")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(postContent);

        mockMvc.perform(request)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("guests"));

        GuestCreationDTO dto = new GuestCreationDTO(
                "Pawel",
                "Cwik",
                LocalDate.parse("2021-09-15"),
                Gender.FEMALE
        );

        Mockito.verify(guestService, Mockito.times(1)).createNewGuest(dto);
    }
}