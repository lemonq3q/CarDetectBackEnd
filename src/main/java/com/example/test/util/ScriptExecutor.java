package com.example.test.util;

import java.io.*;
import java.lang.Runnable;
import java.util.List;

public class ScriptExecutor implements Runnable{

    private final List<String> commandList;
    private final File workingDir;

    public ScriptExecutor(List<String> commandList, File workingDir) {
        this.commandList = commandList;
        this.workingDir = workingDir;
    }

    @Override
    public void run(){
        ProcessBuilder pb = new ProcessBuilder(commandList);
        pb.directory(workingDir);
        try{
            Process process = pb.start();

            readProcessOutput(process);

            int exitCode = process.waitFor();

            System.out.println("External process completed with exit code: " + exitCode);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readProcessOutput(final Process process) {
        // 将进程的正常输出在 System.out 中打印，进程的错误输出在 System.err 中打印
        read(process.getInputStream(), System.out);
        read(process.getErrorStream(), System.err);
    }

    // 读取输入流
    public static void read(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
