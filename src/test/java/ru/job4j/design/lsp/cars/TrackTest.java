package ru.job4j.design.lsp.cars;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackTest {
    @Test
    public void setAndGetNumberOfCars() {
        Place tracks = new Track(8);
        tracks.setNumberOfCars(1);
        assertThat(tracks.getFreePlaces(), is(7));
    }
}