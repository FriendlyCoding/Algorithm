/*ACM-ICPC > Regionals > North America > Rocky Mountain Regional > 
2011 Rocky Mountain Regional Contest E번

Seongsil Heo
*/
#define _CRT_SECURE_NO_WARNINGS
#define SIZE 31
#define H 0

#include <stdio.h>

int main(void)
{
	FILE *file;
	int i, num;
	long long cache[SIZE][SIZE];

	cache[0][0] = 0;

	/*bottom up 방식...*/
	/*w = 0일 때*/
	for (int y = 1; y < SIZE; y++)
	{
		cache[0][y] = 1;
	}

	/*w > 0 일 때*/
	for (int x = 1; x < SIZE; x++)
	{
		for (int y = 0; y < SIZE; y++)
		{
			if (y < 1) /*h < 1 일 때*/
			{
				cache[x][y] = cache[x - 1][y + 1];
			}

			else /* 그 외에 모두*/
			{
				cache[x][y] = cache[x - 1][y + 1] + cache[x][y - 1];
			}

		}
	}

	file = fopen("input.txt", "r");

	while(1)
	{
		fscanf(file, "%d", &num);

		if (num == 0)
			break;

		printf("%lld\n", cache[num][H]);
	}

	return 0;
}