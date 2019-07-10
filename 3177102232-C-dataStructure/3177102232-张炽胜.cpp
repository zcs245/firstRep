#include<stdio.h>
#include<limits.h>
#include<stdlib.h>
#include<string.h>
#define INFINITY INT_MAX
#define MAX_VERTEX_NUM 20 /*��ඥ�����*/
#define Error -1
#define OK 1

/*=====================================�ڽӱ��ʾ����c��������=================================================*/

typedef  enum{DG, DN,UDG,UDN}GraphKind;/*ͼ������: DG��ʾ����ͼ, DN��ʾ������, UDG��ʾ����ͼ, UDN��ʾ������*/

/*�߽��Ķ���*/
typedef int OtherInfo;
typedef struct ArcNode {          
    int adjvex;               /*�û�ָ�򶥵��λ��*/                  
	OtherInfo info;           /*��û���ص���Ϣ������Ȩ*/  
	struct ArcNode  *nextarc; /*ָ����һ������ָ��*/ 
}ArcNode;

/*������Ķ���*/
typedef char VertexData;
typedef struct VertexNode{
   VertexData data[10];    /*��������*/
   ArcNode *firstarc;  /*ָ��ö����һ������ָ��*/ 
}VertexNode;

/*ͼ���ڽӱ��Ķ���*/
typedef struct{
   GraphKind kind;                    /*ͼ�������־*/
   int vexnum;
   int arcnum;                /*ͼ�Ķ������ͻ���*/
   VertexNode vertex[MAX_VERTEX_NUM];    
}AdjList; 


/*=====================================ͼ���ڽӱ��ʾ�����Ļ�������=================================================*/
void CreateWDG(AdjList *G)
{
	ArcNode *s,*z;
	
	G->vexnum=6;
	G->arcnum=8;
	
	VertexData a[10]="����¥";
	VertexData b[10]="���¥";
	VertexData c[10]="��ѧ¥";
	VertexData d[10]="ʳ��";
	VertexData e[10]="����¥";
	VertexData f[10]="ͼ���";

/*********************�ڵ�******************************/	
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
/****************************����************************************/ 

/*****************��һ���ڵ�******************/ 
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
	
	
	/****************�ڶ����ڵ�*******************/ 
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
	
/*****************�������ڵ�**********/ 
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
	
	/***************���ĸ��ڵ�*************/ 
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
	
	/*************������ڵ�************/
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
	printf("��ͼ���£�\n\n");
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
	printf("������Ҫ���ҵ���㣺");
	fflush(stdin);
	gets(q);
	printf("������Ҫ���ҵ��յ㣺");
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
					printf("���·��Ϊ��%s->%s      ��̾���Ϊ��%d     ",q,z,p->info);
														if(p->info<=10)
										{
											printf("�߷�:����\n"); 
											
										}
										else
										{
											if(p->info>10&&p->info<=20)
											{
												printf("�߷�:��С��\n"); 
											}
											else
											{
													printf("�߷�:���ƿ\n"); 
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
										printf("����·��Ϊ��%s->%s->%s      ����Ϊ��%d     ",q,G.vertex[p->adjvex].data,z,p->info+j);
										if(p->info+j<=10)
										{
											printf("�߷�:����\n"); 
										}
										else
										{
											if(p->info+j>10&&p->info+j<=20)
											{
												printf("�߷�:��С��\n"); 
											}
											else
											{
													printf("�߷�:���ƿ\n"); 
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
	printf("������Ҫ���ľ�����ܣ�\n"); 
	gets(s);
	fflush(stdin);
	printf("\n");
	if(strcmp(s, G.vertex[1].data)==0)
	{
		printf("����ĵط�\n");
	}
		if(strcmp(s, G.vertex[2].data)==0)
	{
		printf("���ѧԺ��5¥\n");
	}
		if(strcmp(s, G.vertex[3].data)==0)
	{
		printf("��1A 1B 1C 2A 2B 2C 3A 3B 3C\n");
	}
		if(strcmp(s, G.vertex[4].data)==0)
	{
		printf("��԰ʳ�ã���3�� \n");
	}
		if(strcmp(s, G.vertex[5].data)==0)
	{
		printf("�й�������������ʵ����\n");
	}
		if(strcmp(s, G.vertex[6].data)==0)
	{
		printf("����ͼ��\n");
	}
	printf("\n");
	return 0;
}
int main()
{
	AdjList G;
	G.kind=DN;
	CreateWDG(&G); /*������Ȩ����ͼ*/
	int a;
	printf("      *********************У԰����ϵͳ*******************\n\n");
	while(1)
	{
	printf("�鿴��ͼ ��1         ��ѯ���롢·������ͨ��ʽ ��2         ������� �� 3         �˳� ��4\n");
	printf("�������ѡ��");
	scanf("%d",&a); 
	printf("\n");
	switch (a)
		{
		case 1:
			shuchu(G);/*�鿴��ͼ*/ 
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
