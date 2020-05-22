import json
import pandas as pd


def json_df(data):
    
    # Complete the function
    #
    # You may create other functions if you wish,
    # but make sure this function accepts the JSON
    # string as input and returns a Pandas DataFrame
    
    d = {}
     
 
    k = ""
    v = ""
    for i in data:
        for j in i:
            k = i[j]
            v = j
            if k in d:
                l = d.get(k)
                l.append(v)
                d[k] = l
            else:
                d[k] = [v]
            
            
    
    df = pd.DataFrame(d)
    
    print(df)
    
    return df


# DO NOT EDIT BELOW...
json_df([
    {"a1": "A", "b1": "B", "c1": "C"},
    {"a2": "A", "b2": "B", "c2": "C"},
    {"a3": "A", "b3": "B", "c3": "C"},
    {"a4": "A", "b4": "B", "c4": "C"}
])