<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <title>管理中心</title>
</head>
<body style="margin: 0 auto">
<canvas id='d1' width="600" height="700" style="left: 500px; border:dashed 2px #ccc;position:absolute;z-index:-2;filter: alpha(opacity:50);opacity: 0.5"></canvas>
<script>

    var drawtree = function (ctx, startx, starty, length, angle, depth, branchWidth) {
            var rand = Math.random,
                    n_length, n_angle, n_depth, maxbranch = 4,
                    endx, endy, maxangle = 2 * Math.PI / 4;
            var subbranch;
            ctx.beginPath();
            ctx.moveTo(startx, starty);
            endx = startx + length * Math.cos(angle);
            endy = starty + length * Math.sin(angle);
            ctx.lineCap = 'round';
            ctx.lineWidth = branchWidth;
            ctx.lineTo(endx, endy);
            if (depth <= 2) {
                //树的枝干
                ctx.strokeStyle = 'rgb(0,' + (((rand() * 64) + 128) >> 0) + ',0)';
            }
            else {
                //树的叶子
                ctx.strokeStyle = 'rgb(0,' + (((rand() * 64) + 64) >> 0) + ',50,25)';
            }
            ctx.stroke();
            n_depth = depth - 1;
            //判断树是否结束
            if (!n_depth) {
                return;
            }
            subbranch = (rand() * (maxbranch - 1)) + 1;
            branchWidth *= 0.5;
            for (var i = 0; i < subbranch; i++) {
                n_angle = angle + rand() * maxangle - maxangle * 0.5;
                n_length = length * (0.5 + rand() * 0.5);
                setTimeout(function () {
                    drawtree(ctx, endx, endy, n_length, n_angle, n_depth, branchWidth);
                    return;
                }, 500)
            }
        };

        var canvas1 = document.getElementById('d1');
        var context = canvas1.getContext('2d');
        //初始化的树
        drawtree(context, 300, 700, 200, -Math.PI / 2, 12, 12);
        //context.fill();
        //document.getElementById('YST').style.backgroundImage = 'url("' + context.canvas.toDataURL() + '")';

</script>

<div id="YST" style="width:600px; height:700px;border:dashed 2px #ccc;text-align: center;left: 500px;position:absolute">
    <h2><a href="adminUser">用户管理</a><br><br>
<a href="getMyOrder">订单管理</a><br><br><a href="admin_jingdian.jsp">发布景点</a><br><br>
<br><hr></h2>
#include<stdio.h>
#include"string.h"

#define WORDNUM 65535 // max word number
#define WORDLENGTH 15 // word max length
#define PRINTWORDNUM 15 //out put max word number

char differentword[WORDNUM][WORDLENGTH]={0};//different word info
int differentCount[WORDNUM];//equal word number
int iIndex = 0;//current file word total number
int iWordCount =0;//current file different word number
void GetWordInfo(FILE *fpRead);
void SetWordList(char word[WORDLENGTH]);
void OrderWordList();
void OutPutWordList();
void DealWithWord()
{
    FILE *fpRead;
    if((fpRead = fopen("C:/Users/Administrator/Desktop/word.txt", "r")) == NULL)
    {
       printf("Cannot read file %s\n", "word.txt");
       return;
    }
    GetWordInfo(fpRead);
    OrderWordList();
    OutPutWordList();
}
void GetWordInfo(FILE *fpRead)
{
    int jIndex = 0;
    int i = 0;
    char ch;
    char word[WORDLENGTH]={0};
    while((ch=fgetc(fpRead))!=EOF)
    {
       //putchar(ch);
       if ((ch >= 65 && ch <=90) ||(ch >= 97 && ch <=122))
       {
            if (jIndex < WORDLENGTH)
            {
             word[jIndex] = ch;
             jIndex ++;
            }
       }
       else
       {
            if (jIndex != 0)
            {
             SetWordList(word);
             jIndex = 0;
             iIndex ++;
            }
       }
    } 
}
void SetWordList(char word[WORDLENGTH])
{
    int i;
    int iEqual = 0;
    if (iIndex == 0)
    {
       strcpy(differentword[0],word); 
       differentCount[0] = 0;
       iWordCount ++;
    }
    for (i = 0; i < iWordCount; i ++)
    {
       if (strcmp(differentword[i],word) == 0)
       {
        differentCount[i] ++;
        iEqual = 1;
       }
    }
    if (iEqual == 0)
    {
       strcpy(differentword[iWordCount],word);
       differentCount[iWordCount] ++;
       iWordCount ++;
    }
    for (i = 0; i <WORDLENGTH; i ++)
    {
       word[i] = '\0';
    }
}
void OrderWordList()
{
    int iCurrent = 0;
    int i,j,tempValue;
    char wordTemp[WORDLENGTH]={0};
    for (i = 0; i < iWordCount; i ++)
    {  
       iCurrent = i;
       for (j = i + 1; j < iWordCount; j ++)
       {
        if (differentCount[iCurrent] < differentCount[j])
        {
         iCurrent = j;
        }
       } 
       if (iCurrent != i)
       {
        tempValue = differentCount[iCurrent];
        differentCount[iCurrent] = differentCount[i];
        differentCount[i] = tempValue;
        strcpy(wordTemp,differentword[iCurrent]);
        strcpy(differentword[iCurrent],differentword[i]); 
        strcpy(differentword[i],wordTemp); 
       }
    }
}
void OutPutWordList()
{
    int i;
    for (i = 0; i < iWordCount && i < PRINTWORDNUM; i ++)
    {
       printf("%s %d\n", differentword[i], differentCount[i]);
    }
}
int main(int argc, char* argv[])
{
    DealWithWord();
    getchar();
}
</p>
</div>
</body>

</html>
