package com.example.caiquan2.slice;

import com.example.caiquan2.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

import java.util.Random;

public class MainAbilitySlice extends AbilitySlice {
    static Button bu;
    static Button shitou;
    static Button jiandao;
    static Text defen;
    static Image enemy;
    static Integer core=0;
    Random random=new Random();

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_mainslice);
            initView();

    }

    public void initView()
    {
        bu= (Button) findComponentById(ResourceTable.Id_bu);
        shitou= (Button) findComponentById(ResourceTable.Id_shitou);
        jiandao= (Button) findComponentById(ResourceTable.Id_jiandao);
        defen= (Text) findComponentById(ResourceTable.Id_defen);
        enemy= (Image) findComponentById(ResourceTable.Id_enemy);
        bu.setClickedListener(this::chuli);
        shitou.setClickedListener(this::chuli);
        jiandao.setClickedListener(this::chuli);

    }




    private void chuli(Component component)
    {   int way;
        String name=component.getName();
        if(name.equals("Id_shitou"))
            way=0;
        else if(name.equals("Id_jiandao"))
            way=1;
        else
            way=2;

        System.out.println(name+":"+way);

        int enemyway=random.nextInt(3);
        //0石头 1 剪刀 2 布

        System.out.println(enemyway);
        if(enemyway==0)
            enemy.setPixelMap(ResourceTable.Media_shitou);
        else if(enemyway==1)
            enemy.setPixelMap(ResourceTable.Media_jiandao);
        else
            enemy.setPixelMap(ResourceTable.Media_bu);

        if(way==0)
        {
            if(enemyway==1)
                core++;
            else if(enemyway==2)
                core--;
        }
        else if(way==1)
        {
            if(enemyway==2)
                core++;
            else if(enemyway==0)
                core--;
        }
        else
        {
            if(enemyway==0)
                core++;
            else if(enemyway==1)
                core--;
        }
        defen.setText(core.toString());



    }



    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
