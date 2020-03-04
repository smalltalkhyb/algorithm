package com.hyb.algorithm.data.struct.structure.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(IGraph graph, String filename) {
        String dir = "F:\\Workspace2019\\Java\\201906\\algorithm\\data\\";
        filename = dir + filename;
        readFile(filename);

        try {

            int V = scanner.nextInt();
            if (V <= 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            }

            int E = scanner.nextInt();

            if (E < 0) {
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            }

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                graph.addEdge(v, w);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void readFile(String filename) {
        try {
            File file = new File(filename);

            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
            scanner.useLocale(Locale.ENGLISH);

            if (!file.exists()) {
                throw new IllegalArgumentException(filename + "doesn't exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
