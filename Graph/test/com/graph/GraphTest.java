package com.graph;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class GraphTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Graph.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    public Graph g1 = new Graph();

    @org.junit.Test
    public void initGraph()  {
        Map<String, List<String>> AimGraph = new HashMap<String, List<String>>();
        AimGraph.put("", Arrays.asList(""));
        AimGraph.put("", Arrays.asList(""));
        AimGraph.put("", Arrays.asList(""));
        AimGraph.put("", Arrays.asList(""));
        AimGraph.put("", Arrays.asList(""));
    }
}
