package tech.ada.adamon.util;

import tech.ada.adamon.model.Adamon;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

    private TestUtils() {}
    public static List<Adamon> obterAdamons() {
        Adamon adamon = new Adamon();
        Adamon adamon1 = new Adamon();
        Adamon adamon2 = new Adamon();
        Adamon adamon3 = new Adamon();
        return Arrays.asList(adamon, adamon1, adamon2, adamon3);
    }
}
