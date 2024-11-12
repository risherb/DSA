import pandas as pd

def dropMissingData(students: pd.DataFrame) -> pd.DataFrame:
    df=pd.DataFrame(students)
    df=df.dropna(subset="name")
    return df


    