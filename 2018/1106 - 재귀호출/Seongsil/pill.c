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
	int i, num, cases;
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
	fscanf(file, "%d", &cases);

	for (int i = 0; i < cases; i++)
	{
		fscanf(file, "%d", &num);
		printf("%lld\n", cache[num][H]);
	}
	return 0;
}




/*재귀함수 - runtime error
int recursiveNum(int w, int h)
{

if (w == 0)
{
return 1;
}
else if ((w > 0) && (h < 1))
{
return recursiveNum(w - 1, h + 1);
}

else
{
return recursiveNum(w - 1, h + 1) + recursiveNum(w, h - 1);

}
}*/