package cc.moecraft.hykilpikonna.fgo.summonsimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            try
            {
                System.out.print("输入模拟次数: ");
                int sampleSize = Integer.valueOf(input.readLine());

                System.out.print("输入石头数量: ");
                int amountOfQuartz = Integer.valueOf(input.readLine());

                long time = System.currentTimeMillis();
                System.out.println(Generator.simulate(sampleSize, amountOfQuartz).toString());
                System.out.println("耗时: " + (System.currentTimeMillis() - time) + "ms");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
