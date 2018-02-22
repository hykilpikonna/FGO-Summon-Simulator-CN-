package cc.moecraft.hykilpikonna.fgo.summonsimulator;

import java.util.Random;

/**
 * 此类由 Hykilpikonna 在 2018/02/22 创建!
 * Created by Hykilpikonna on 2018/02/22!
 * Twitter: @Hykilpikonna
 * QQ/Wechat: 871674895
 */
public class Generator
{
    public static SimulateDataSet simulate(int sampleSize, int quartz)
    {
        Random random = new Random();

        int tens = quartz / 30;
        int singles = (quartz - tens * 30) / 3;

        SimulateDataSet dataSet = new SimulateDataSet(sampleSize, quartz);

        for (int z = 0; z < sampleSize; z++)
        {
            SimulateData result = new SimulateData(new int[6], new int[6]);

            // 所有十连
            for (int i = 0; i < tens; i++)
            {
                boolean containsAtLeastFourStars = false;
                for (int j = 0; j < 9; j++)
                {
                    int r = pullOne(random);
                    containsAtLeastFourStars = containsAtLeastFourStars || countOne(r, result);
                }

                int r = containsAtLeastFourStars ? pullOne(random) : pullOneNoThreeStar(random);
                countOne(r, result);
            }

            // 所有单抽
            for (int j = 0; j < singles; j++)
            {
                int r = pullOne(random);
                countOne(r, result);
            }

            dataSet.dataSet.add(result);
        }

        return dataSet;
    }

    /**
     * return is four or five star servant or not
     * @return 是不是四星或五星
     */
    private static boolean countOne(int pull, SimulateData result)
    {
        switch (pull)
        {
            case 15:
                result.servantsCount[5] ++;
                return true;
            case 14:
                result.servantsCount[4] ++;
                return true;
            case 13:
                result.servantsCount[3] ++;
                return false;
            case 25:
                result.craftEssenceCount[5] ++;
                return true;
            case 24:
                result.craftEssenceCount[4] ++;
                return true;
            case 23:
                result.craftEssenceCount[3] ++;
                return false;
        }
        return false;
    }

    private static int pullOne(Random random)
    {
        int r = random.nextInt(100);
        if (r < 2) return 15;
        else if (r < 5) return 14;
        else if (r < 9) return 25;
        else if (r < 21) return 24;
        else if (r < 61) return 13;
        else return 23;
    }

    private static int pullOneNoThreeStar(Random random)
    {
        int r = random.nextInt(100);
        if (r < 2) return 15;
        else if (r < 5) return 14;
        else if (r < 9) return 25;
        else return 24;
    }
}
