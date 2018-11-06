/*백준 검색엔진

2018/11/05 Fail
Seongsil Heo
*/
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

#define SIZE 51

int score(int alpha, int num, int link);
int main(void)
{
	FILE *file;
	int alpha_num, alpha_main,alpha_sub, link_num, alpha_res;
	int linked[SIZE][SIZE] = 0;
	char alpha[SIZE];

	file = fopen("input.txt", "r");
	fscanf(file, "%d", &alpha_num);
	for (int i = 0; i < alpha_num; i++) // 0 : A
	{
		int linked_num = 0;
		fscanf(file, "%c, %d", &alpha_main, &link_num);

		alpha[i] = "alpha_main";
		for (int j = 0; j < link_num; j++) 
		{
			fscanf(file, "%c", alpha_sub);

			if (linked[j][i] == 0) { //링크 직접 걸려있지 않을 때
				linked[i][j] = 1;
			}

		}
	}
	fscanf(file, "%c", &alpha_res);

	for (int i = 0; i < alpha_num; i++)
	{
		if (!strcmp(alpha_res, alpha[i]))
		{
			printf("%d",score(i,alpha_num, linked[SIZE][SIZE]));
		}
	}


	return 0;
}
int score(int alpha, int num, int link)
{
	int score = 0; 

	for (int i = 0; i < num; i++)
	{
	}
}