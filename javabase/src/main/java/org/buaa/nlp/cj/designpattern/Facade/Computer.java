package org.buaa.nlp.cj.designpattern.Facade;

/**
 * Created by Administrator on 2015/5/18.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;
    Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup() {
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finish!");
    }

    public void shutdown() {
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!");
    }
}
