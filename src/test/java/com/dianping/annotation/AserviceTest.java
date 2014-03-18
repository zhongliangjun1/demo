package com.dianping.annotation;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-18
 * Time: PM12:02
 * To change this template use File | Settings | File Templates.
 */
public class AserviceTest {

    private static Dao adao;
    private static Dao bdao;
    private static List<Dao> daos;

    @BeforeClass
    public static void setUp() {
        adao = mock(Adao.class);
        when(adao.load()).thenReturn("success");

        bdao = mock(Bdao.class);
        when(bdao.load()).thenReturn("success");

        daos = new ArrayList<Dao>();
        daos.add(adao);
        daos.add(bdao);
    }

    @Test
    public void testTest() {
        Aservice aservice = new Aservice();
        ReflectionTestUtils.setField(aservice, "adao", adao);
        ReflectionTestUtils.setField(aservice, "bdao", bdao);
        ReflectionTestUtils.setField(aservice, "daos", daos);
        aservice.test();
    }


}
