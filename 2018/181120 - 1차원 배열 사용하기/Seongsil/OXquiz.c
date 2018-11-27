#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main(void)
{
	char OX[81];
	int n;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%s", &OX);
		int score = 0;
		int total_score = 0;
		for (int j = 0; j < strlen(OX); j++)
		{
			if (OX[j] == 'O')
			{
				score++; 
				total_score += score;
			}

			else if (OX[j] == 'X')
			{
				score = 0;
			}
			else
			{
				break;
			}
			
		}
		printf("%d\n", total_score);
	}


	return 0;

}