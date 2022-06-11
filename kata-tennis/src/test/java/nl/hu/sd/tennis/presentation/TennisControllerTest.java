package nl.hu.sd.tennis.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.sd.tennis.application.TennisService;
import nl.hu.sd.tennis.application.dto.GameDTO;
import nl.hu.sd.tennis.application.dto.NewGameDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class TennisControllerTest {
    @Autowired
    private ObjectMapper jsonMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TennisService tennisService;

    private <T> T getSingleJsonResult(MvcResult result, Class<T> resultClass) throws UnsupportedEncodingException, JsonProcessingException {
        return jsonMapper.readValue(result.getResponse().getContentAsString(), resultClass);
    }

    private <T> List<T> getJsonResults(MvcResult result, Class<T> resultClass) throws UnsupportedEncodingException, JsonProcessingException {
        return jsonMapper.readValue(result.getResponse().getContentAsString(), jsonMapper.getTypeFactory().constructCollectionType(List.class, resultClass));
    }

    @Test
    public void canListGames() throws Exception {
        GameDTO demoGame = new GameDTO(42L, "Bob", "Ross");
        when(tennisService.getGames()).thenReturn(List.of(demoGame));

        MvcResult mvcResult = mockMvc.perform(get("/games")).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

        List<GameDTO> results = getJsonResults(mvcResult, GameDTO.class);
        assertEquals(1, results.size());
        assertEquals(demoGame, results.get(0));
    }

    @Test
    public void canFindSingleGame() throws Exception {
        GameDTO expectedResult = new GameDTO(42L, "Bob", "Ross");
        when(tennisService.getGame(42L)).thenReturn(Optional.of(expectedResult));

        MvcResult mvcResult = mockMvc.perform(get("/games/42")).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

        GameDTO returnedGame = getSingleJsonResult(mvcResult, GameDTO.class);
        assertEquals(expectedResult, returnedGame);
    }

    @Test
    public void returns404OnMissingGame() throws Exception {
        when(tennisService.getGame(42L)).thenReturn(Optional.empty());

        MvcResult mvcResult = mockMvc.perform(get("/games/42")).andReturn();
        assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    public void canCreateGame() throws Exception {
        NewGameDTO newGameDTO = new NewGameDTO("Bon", "Jovi");
        GameDTO expectedResult = new GameDTO(44L, "Bon", "Jovi");

        when(tennisService.startGame(newGameDTO)).thenReturn(expectedResult);

        MvcResult mvcResult = mockMvc.perform(
                        post("/games")
                                .content(jsonMapper.writeValueAsString(newGameDTO))
                                .contentType("application/json"))
                .andReturn();

        assertEquals(201, mvcResult.getResponse().getStatus());
        assertEquals("http://localhost/games/44", mvcResult.getResponse().getHeader("Location"));
        assertEquals(expectedResult, getSingleJsonResult(mvcResult, GameDTO.class));
    }

    @Test
    public void returns400OnInvalidDTO() throws Exception {
        String jsonSnippet = """
                {
                    "server": "Tom",
                    "Receiver": "Hugo"
                }
                """; //Typo with a field, should yield a clear error

        MvcResult mvcResult = mockMvc.perform(
                        post("/games")
                                .content(jsonSnippet)
                                .contentType("application/json"))
                .andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());
    }
}