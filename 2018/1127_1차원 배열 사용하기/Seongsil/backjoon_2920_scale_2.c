/*baekjoon- 2920. 음계
Seongsil Heo */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define totalNum 8
int main(void)
{
	int tmp = 0, preTmp = 0;
	bool isAsc = false, isDsc = false, isMix = false;
	
	scanf("%d", &preTmp);

	for (int i = 1; i < totalNum; i++)
	{
		scanf("%d", &tmp);
		if (preTmp < tmp)
		{
			isAsc = true;
		}

		else
		{
			isDsc = true;
		}

		if (isAsc && isDsc) 
			break;
		else preTmp = tmp;
	}

	if (isAsc && isDsc)
	{
		printf("mixed");
	}
	else if (isAsc)
	{
		printf("ascending");
	}

	else
	{
		printf("descending");
	}
	return 0;
}
