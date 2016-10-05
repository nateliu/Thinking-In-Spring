package org.springframework.samples.controllers;

import org.junit.Test;
import org.springframework.samples.models.Spittle;
import org.springframework.samples.models.Spittler;
import org.springframework.samples.repositories.ISpittleRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
public class SpittleControllerTest {
    @Test
    public void shouldShowRecentSpittlesTest() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        ISpittleRepository mockRepository = mock(ISpittleRepository.class);
        when(mockRepository.finSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowPagedSpittlesTest() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        ISpittleRepository mockRepository = mock(ISpittleRepository.class);
        when(mockRepository.finSpittles(238900, 20)).thenReturn(expectedSpittles);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/pagedSpittles?max=238900&count=50"))
                .andExpect(view().name("pagedSpittles"))
                .andExpect(model().attributeExists("spittleList"));
    }

    @Test
    public void spittleTest() throws Exception {
        Spittle expectedSpittle = new Spittle(100L, "Hello", new Date());
        ISpittleRepository mockRepository = mock(ISpittleRepository.class);
        when(mockRepository.finOne(12345)).thenReturn(expectedSpittle);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }

    @Test
    public void showRegisterTest() throws Exception {
        SpittleController controller = new SpittleController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spittler/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void processRegisterTest() throws Exception {
        ISpittleRepository mockRepository = mock(ISpittleRepository.class);
        Spittler savedSpittler = new Spittler(100L, "Nate", "Liu", "Nate Liu", "12345", "test@163.com");
        when(mockRepository.save(any(Spittler.class))).thenReturn(savedSpittler);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spittler/register").param("firstName", "Nate").param("lastName", "Liu").param("userName", "nliu").param("passWord", "12345").param("email", "test@163.com"))
                .andExpect(redirectedUrl("/spittler/nliu"));
        verify(mockRepository, atLeastOnce()).save(any(Spittler.class));
    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle((long) (i + 100), "Spittle " + i, new Date()));
        }
        return spittles;
    }
}