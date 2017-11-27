package cn.hfbin.coll013;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {

    public static void main(String[] args) {

        //底层实现都是加锁的

        CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();

        //如   按住ctrl 进入源码
        cwal.add("k1");
        cwal.add("k2");
        cwal.add("k3");
        cwas.add("q1");
        cwas.add("q2");
        cwas.add("q3");

        System.out.println(cwal.toString());

        System.out.println(cwas.toString());


    }
}
