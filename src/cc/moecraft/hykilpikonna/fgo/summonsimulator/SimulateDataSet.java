package cc.moecraft.hykilpikonna.fgo.summonsimulator;

import java.util.ArrayList;

/**
 * 此类由 Hykilpikonna 在 2018/02/22 创建!
 * Created by Hykilpikonna on 2018/02/22!
 * Twitter: @Hykilpikonna
 * QQ/Wechat: 871674895
 */
public class SimulateDataSet
{
    public ArrayList<SimulateData> dataSet = new ArrayList<>();

    public double[] averageServentPerAccount = new double[6];
    public double[] averageCEPerAccount = new double[6];
    int sampleSize, quartz;

    public SimulateDataSet(int sampleSize, int quartz)
    {
        this.sampleSize = sampleSize;
        this.quartz = quartz;
    }

    public void calculateAverage()
    {
        double[] totalServentPerAccount = new double[6];
        double[] totalCEPerAccount = new double[6];

        for (SimulateData data : dataSet)
        {
            totalServentPerAccount[5] += data.servantsCount[5];
            totalServentPerAccount[4] += data.servantsCount[4];
            totalCEPerAccount[5] += data.craftEssenceCount[5];
            totalCEPerAccount[4] += data.craftEssenceCount[4];
        }

        averageServentPerAccount[5] = totalServentPerAccount[5] / sampleSize;
        averageServentPerAccount[4] = totalServentPerAccount[4] / sampleSize;
        averageCEPerAccount[5] = totalCEPerAccount[5] / sampleSize;
        averageCEPerAccount[4] = totalCEPerAccount[4] / sampleSize;
    }

    @Override
    public String toString()
    {
        calculateAverage();
        return String.format("全部模拟完成: \n - 样本数量: %s \n - 圣晶石数量: %s \n - 每个号平均五星从者: %s \n - 每个号平均五星礼装: %s \n - 每个号平均四星从者: %s \n - 每个号平均四星礼装: %s",
                sampleSize, quartz,
                averageServentPerAccount[5], averageCEPerAccount[5], averageServentPerAccount[4], averageCEPerAccount[4]);
    }
}
