package com.demo.concurrency;
import com.demo.algorithm.UF;
import com.demo.algorithm.UnionFind;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;


public class RosterCallableFuture {
    private String pname;
    private Integer pnum;
    private String pteam;
    private String pskill;

    public RosterCallableFuture(){}
    public RosterCallableFuture(String pname, Integer pnum, String pteam, String pskill) {
        this.pname = pname;
        this.pnum = pnum;
        this.pteam = pteam;   // Include the team parameter
        this.pskill = pskill; // Include the skill parameter
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UF uf = new UnionFind();
        File createdFile = uf.createFileIfNotExist("player.txt");
        Map<Integer, Object> map = uf.GetFileData2(createdFile);
        // create roster object;
        // Roster roster = new Roster();

        // create es and pool size
        ExecutorService es = Executors.newFixedThreadPool(2);

        for(Integer key: map.keySet()){
            Map<Integer, Object> rosterMap = new HashMap<>();

            Callable<Map> c1 =  () -> {
                // ask for thread info inside the callable
                // perform task inside callable
                System.out.println(Thread.currentThread().getName());
                rosterMap.put(key, map.get(key));
                return rosterMap;
            };
            // submit 3 callables and return 3 futures
            Future<Map> f1 = es.submit(c1);
            System.out.println(f1.get());
        }

        // shutdown
        es.shutdown();

    }
    @Override
    public String toString() {
        return "Roster{" +
                "pname='" + pname + '\'' +
                ", pnum=" + pnum +
                ", pteam='" + pteam + '\'' +
                ", pskill='" + pskill + '\'' +
                '}';
    }



}
