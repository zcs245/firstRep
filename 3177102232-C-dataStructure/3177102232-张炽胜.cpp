#include<stdio.h>
#include<limits.h>
#include<stdlib.h>
#include<string.h>
#define INFINITY INT_MAX
#define MAX_VERTEX_NUM 20 /*最多顶点个数*/
#define Error -1
#define OK 1

/*=====================================邻接表表示法的c语言描述=================================================*/

typedef  enum{DG, DN,UDG,UDN}GraphKind;/*图的种类: DG表示有向图, DN表示有向网, UDG表示无向图, UDN表示无向网*/

/*边结点的定义*/
typedef int OtherInfo;
typedef struct ArcNode {          
    int adjvex;               /*该弧指向顶点的位置*/                  
	OtherInfo info;           /*与该弧相关的信息，比如权*/  
	struct ArcNode  *nextarc; /*指向下一条弧的指针*/ 
}ArcNode;

/*顶点结点的定义*/
typedef char VertexData;
typedef struct VertexNode{
   VertexData data[10];    /*顶点数据*/
   ArcNode *firstarc;  /*指向该顶点第一条弧的指针*/ 
}VertexNode;

/*图（邻接表）的定义*/
typedef struct{
   GraphKind kind;                    /*图的种类标志*/
   int vexnum;
   int arcnum;                /*图的顶点数和弧数*/
   VertexNode vertex[MAX_VERTEX_NUM];    
}AdjList; 


/*=====================================图（邻接表表示法）的基本操作=================================================*/
void CreateWDG(AdjList *G)
{
	ArcNode *s,*z;
	
	G->vexnum=6;
	G->arcnum=8;
	
	VertexData a[10]="宿舍楼";
	VertexData b[10]="务成楼";
	VertexData c[10]="教学楼";
	VertexData d[10]="食堂";
	VertexData e[10]="工科楼";
	VertexData f[10]="图书馆";

/*********************节点******************************/	
	strcpy(G->vertex[1].data,a);
	G->vertex[1].firstarc=NULL;
	
	strcpy(G->vertex[2].data,b);
	G->vertex[2].firstarc=NULL;
	
	strcpy(G->vertex[3].data,c);
	G->vertex[3].firstarc=NULL;
	
	strcpy(G->vertex[4].data,d);
	G->vertex[4].firstarc=NULL;
	
	strcpy(G->vertex[5].data,e);
	G->vertex[5].firstarc=NULL;
	
	strcpy(G->vertex[6].data,f);
	G->vertex[6].firstarc=NULL;
/****************************连接************************************/ 

/*****************第一个节点******************/ 
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=3;
	s->info=10;
	s->nextarc=G->vertex[1].firstarc;
	G->vertex[1].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=1;
	z->info=10;
	z->nextarc=G->vertex[3].firstarc;
	G->vertex[3].firstarc=z;
	
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=4;
	s->info=20;
	s->nextarc=G->vertex[1].firstarc;
	G->vertex[1].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=1;
	z->info=20;
	z->nextarc=G->vertex[4].firstarc;
	G->vertex[4].firstarc=z;
	
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=5;
	s->info=30;
	s->nextarc=G->vertex[1].firstarc;
	G->vertex[1].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=1;
	z->info=30;
	z->nextarc=G->vertex[5].firstarc;
	G->vertex[5].firstarc=z;
	
	
	/****************第二个节点*******************/ 
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=2;
	s->info=10;
	s->nextarc=G->vertex[3].firstarc;
	G->vertex[3].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=3;
	z->info=10;
	z->nextarc=G->vertex[2].firstarc;
	G->vertex[2].firstarc=z;
	
	s=(ArcNode *)malloc(sizeof(ArcNode));
	s->adjvex=2;
	s->info=5;
	s->nextarc=G->vertex[5].firstarc;
	G->vertex[5].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=5;
	z->info=5;
	z->nextarc=G->vertex[2].firstarc;
	G->vertex[2].firstarc=z;
	
/*****************第三个节点**********/ 
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=3;
	s->info=10;
	s->nextarc=G->vertex[6].firstarc;
	G->vertex[6].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=6;
	z->info=10;
	z->nextarc=G->vertex[3].firstarc;
	G->vertex[3].firstarc=z;
	
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=3;
	s->info=10;
	s->nextarc=G->vertex[4].firstarc;
	G->vertex[4].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=4;
	z->info=10;
	z->nextarc=G->vertex[3].firstarc;
	G->vertex[3].firstarc=z;
	
	/***************第四个节点*************/ 
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=4;
	s->info=20;
	s->nextarc=G->vertex[6].firstarc;
	G->vertex[6].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=6;
	z->info=20;
	z->nextarc=G->vertex[4].firstarc;
	G->vertex[4].firstarc=z;
	
	/*************第五个节点************/
	s=(ArcNode *)malloc(sizeof(ArcNode));	
	s->adjvex=5;
	s->info=15;
	s->nextarc=G->vertex[6].firstarc;
	G->vertex[6].firstarc=s;
	
	z=(ArcNode *)malloc(sizeof(ArcNode));
	z->adjvex=6;
	z->info=15;
	z->nextarc=G->vertex[5].firstarc;
	G->vertex[5].firstarc=z;
}

void shuchu(AdjList G)
{
	int i;
	ArcNode *p;
	printf("地图如下：\n\n");
	for(i=1; i<=G.vexnum; i++)
	{	printf("[%s|->] ", G.vertex[i].data);
		for(p=G.vertex[i].firstarc; p; p=p->nextarc)
			printf("%s ", G.vertex[p->adjvex].data);
		printf("\n");
	}
		printf("\n");
}

int chazhao(AdjList G)
{
	int i=1,j=0;
	ArcNode *p,*o;
	VertexData q[10];
	VertexData z[10];
	printf("输入你要查找的起点：");
	fflush(stdin);
	gets(q);
	printf("输入你要查找的终点：");
	fflush(stdin);
	gets(z);
	printf("\n");
	for(i;i<=6;i++)
	{
		if(strcmp(q, G.vertex[i].data)==0)
		{
			for(p=G.vertex[i].firstarc;p; p=p->nextarc)
			{
				if(strcmp(z, G.vertex[p->adjvex].data)==0)
				{
					printf("最短路径为：%s->%s      最短距离为：%d     ",q,z,p->info);
														if(p->info<=10)
										{
											printf("走法:步行\n"); 
											
										}
										else
										{
											if(p->info>10&&p->info<=20)
											{
												printf("走法:骑小黄\n"); 
											}
											else
											{
													printf("走法:骑电瓶\n"); 
											}
										}
										printf("\n");
					return 0;
				}
				else
				{
					j=p->info;
						for(o=G.vertex[p->adjvex].firstarc;o;o=o->nextarc)
							{
								if(strcmp(z, G.vertex[o->adjvex].data)==0)
									{ 
										printf("部分路径为：%s->%s->%s      距离为：%d     ",q,G.vertex[p->adjvex].data,z,p->info+j);
										if(p->info+j<=10)
										{
											printf("走法:步行\n"); 
										}
										else
										{
											if(p->info+j>10&&p->info+j<=20)
											{
												printf("走法:骑小黄\n"); 
											}
											else
											{
													printf("走法:骑电瓶\n"); 
											}
										}
										printf("\n");
									}
								else
									{
									}
							}
				}
			}
		}
		else
		{
		} 
	}
}
int jieshao(AdjList G)
{
	fflush(stdin);
	VertexData s[10];
	int i=1;
	printf("输入你要看的景点介绍：\n"); 
	gets(s);
	fflush(stdin);
	printf("\n");
	if(strcmp(s, G.vertex[1].data)==0)
	{
		printf("生活的地方\n");
	}
		if(strcmp(s, G.vertex[2].data)==0)
	{
		printf("软件学院在5楼\n");
	}
		if(strcmp(s, G.vertex[3].data)==0)
	{
		printf("有1A 1B 1C 2A 2B 2C 3A 3B 3C\n");
	}
		if(strcmp(s, G.vertex[4].data)==0)
	{
		printf("松园食堂，有3层 \n");
	}
		if(strcmp(s, G.vertex[5].data)==0)
	{
		printf("有公共机房与计算机实验室\n");
	}
		if(strcmp(s, G.vertex[6].data)==0)
	{
		printf("借阅图书\n");
	}
	printf("\n");
	return 0;
}
int main()
{
	AdjList G;
	G.kind=DN;
	CreateWDG(&G); /*创建赋权有向图*/
	int a;
	printf("      *********************校园导游系统*******************\n\n");
	while(1)
	{
	printf("查看地图 按1         查询距离、路径、交通方式 按2         景点介绍 按 3         退出 按4\n");
	printf("输入你的选择：");
	scanf("%d",&a); 
	printf("\n");
	switch (a)
		{
		case 1:
			shuchu(G);/*查看地图*/ 
			break;
		case 2: 
			chazhao(G); 
			break;
	
		case 3:
			jieshao(G);
			break;
		case 4:
		return 0;
		break; 
		}
	}
	return 0;
}
