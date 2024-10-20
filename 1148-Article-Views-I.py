import pandas as pd

def article_views(df: pd.DataFrame) -> pd.DataFrame:
    df=df[(df['author_id'])==(df['viewer_id'])]
    df=df.drop_duplicates(subset=['author_id'],keep='first')
    df=df.rename(columns={'author_id': 'id'})
    return df[['id']].sort_values(by=['id'],ascending=True)