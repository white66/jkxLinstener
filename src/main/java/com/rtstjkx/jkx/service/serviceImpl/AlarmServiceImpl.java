package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.Alarm;
import com.rtstjkx.jkx.repository.AlarmMapper;
import com.rtstjkx.jkx.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlarmServiceImpl implements AlarmService{
    @Autowired
    AlarmMapper alarmMapper;

    /**
     * 查询全区总告警数
     * @return
     */
    @Override
    public Map<String, Object> getAlarmList() {
        int zyqx = 0;//左右倾斜告警数初始值
        int qhqx = 0;//前后倾斜告警数初始值
        int sj = 0;//水浸告警数初始值
        int mc = 0;//门磁告警数初始值
        int fj = 0;//风机
        int led = 0;//LED照明
        int fl = 0;//防雷
        int jldgj = 0;//交流电告警
        int jld = 0;//交流掉电
        Map<String, Object> resultMap = new LinkedHashMap<>();
        List<Alarm> alarmList = alarmMapper.getAlarmList();

        for (Alarm alarm :alarmList) {
            char[] bitValueB = alarm.getBITValueB().toCharArray();
            char[] bitValueC = alarm.getBITValueC().toCharArray();
            if(bitValueB[1]=='1'){//根据第二个状态字节的第二位数值判断左右倾斜告警 1表示告警 0表示正常
                zyqx=zyqx+1;
            }
            if(bitValueB[0]=='1'){//根据第二个状态字节的第一位数值判断前后倾斜告警 1表示告警 0表示正常
                qhqx=qhqx+1;
            }
            if (bitValueB[2]=='1'){//根据第二个状态字节的第三位数值判断水浸告警 1表示告警 0表示正常
                sj++;
            }
            if(bitValueC[0]=='1'){//根据第三个状态字节的第一位数值判断门磁开关状态 1表示开 0 表示关
                mc=mc+1;
            }
            if(bitValueC[1]=='1'){//根据第三个状态字节的第二位数值判断风机状态 1表示开  0表示正常
                fj=fj+1;
            }
            if(bitValueC[2]=='1'){//根据第三个状态字节的第三位数值判断LED灯状态 1表示开  0表示关
                led=led+1;
            }
            if (bitValueC[3]=='1'){//根据第三个状态字节的第四位数值判断防雷告警 1表示开  0表示正常
                fl=fl+1;
            }
            if (bitValueC[5]=='1'||bitValueC[6]=='1'){//根据第三个状态字节的第五、六位数值判断交流电上限和下限告警 1表示告警  0表示正常
                jldgj=jldgj+1;
            }
            if(bitValueC[7]=='1'){//根据第三个状态字节第八个数值判断交流电掉电
                jld=jld+1;
            }
        }
        resultMap.put("zyqx",zyqx);
        resultMap.put("qhqx",qhqx);
        resultMap.put("sj",sj);
        resultMap.put("mc",mc);
        resultMap.put("fj",fj);
        resultMap.put("led",led);
        resultMap.put("fl",fl);
        resultMap.put("jldgj",jldgj);
        resultMap.put("jld",jld);
        return  resultMap;
    }

    /**
     * 查询指定派出所下的站点告警总和
     * @param PCS_Code
     * @return
     */
    @Override
    public Map<String,Object> getAlarmByPCS(String PCS_Code){
        int zyqx = 0;//左右倾斜告警数初始值
        int qhqx = 0;//前后倾斜告警数初始值
        int sj = 0;//水浸告警数初始值
        int mc = 0;//门磁告警数初始值
        int fj = 0;//风机
        int led = 0;//LED照明
        int fl = 0;//防雷
        int jldgj = 0;//交流电告警
        int jld = 0;//交流掉电
        Map<String, Object> resultMap = new LinkedHashMap<>();
        List<Alarm> alarmList = alarmMapper.getAlarmByPCS(PCS_Code);

        for (Alarm alarm :alarmList) {
            char[] bitValueB = alarm.getBITValueB().toCharArray();
            char[] bitValueC = alarm.getBITValueC().toCharArray();
            if(bitValueB[1]=='1'){//根据第二个状态字节的第二位数值判断左右倾斜告警 1表示告警 0表示正常
                zyqx=zyqx+1;
            }
            if(bitValueB[0]=='1'){//根据第二个状态字节的第一位数值判断前后倾斜告警 1表示告警 0表示正常
                qhqx=qhqx+1;
            }
            if (bitValueB[2]=='1'){//根据第二个状态字节的第三位数值判断水浸告警 1表示告警 0表示正常
                sj++;
            }
            if(bitValueC[0]=='1'){//根据第三个状态字节的第一位数值判断门磁开关状态 1表示开 0 表示关
                mc=mc+1;
            }
            if(bitValueC[1]=='1'){//根据第三个状态字节的第二位数值判断风机状态 1表示开  0表示正常
                fj=fj+1;
            }
            if(bitValueC[2]=='1'){//根据第三个状态字节的第三位数值判断LED灯状态 1表示开  0表示关
                led=led+1;
            }
            if (bitValueC[3]=='1'){//根据第三个状态字节的第四位数值判断防雷告警 1表示开  0表示正常
                fl=fl+1;
            }
            if (bitValueC[5]=='1'||bitValueC[6]=='1'){//根据第三个状态字节的第五、六位数值判断交流电上限和下限告警 1表示告警  0表示正常
                jldgj=jldgj+1;
            }
            if(bitValueC[7]=='1'){//根据第三个状态字节第八个数值判断交流电掉电
                jld=jld+1;
            }
        }
        resultMap.put("zyqx",zyqx);
        resultMap.put("qhqx",qhqx);
        resultMap.put("sj",sj);
        resultMap.put("mc",mc);
        resultMap.put("fj",fj);
        resultMap.put("led",led);
        resultMap.put("fl",fl);
        resultMap.put("jldgj",jldgj);
        resultMap.put("jld",jld);
        return  resultMap;
    }

    public static interface AuthService {
        Set<String> findAuthByRoleIds(List<Integer> roleIds);
    }
}
