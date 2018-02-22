package cc.moecraft.hykilpikonna.fgo.summonsimulator;

/**
 * 此类由 Hykilpikonna 在 2018/02/22 创建!
 * Created by Hykilpikonna on 2018/02/22!
 * Twitter: @Hykilpikonna
 * QQ/Wechat: 871674895
 */
public class SimulateData
{
    // 例子: 抽到的三星从者数量 = servantsCount[3]
    public int[] servantsCount = new int[6];

    public int[] craftEssenceCount = new int[6];

    public SimulateData(int[] servantsCount, int[] craftEssenceCount)
    {
        this.servantsCount = servantsCount;
        this.craftEssenceCount = craftEssenceCount;
    }

    @Override
    public String toString()
    {
        return String.format("[一次模拟完成: 五星从者: %s, 五星礼装: %s, 四星从者: %s, 四星礼装: %s, 三星从者: %s, 三星礼装: %s]", servantsCount[5], craftEssenceCount[5], servantsCount[4], craftEssenceCount[4], servantsCount[3], craftEssenceCount[3]);
    }
}
