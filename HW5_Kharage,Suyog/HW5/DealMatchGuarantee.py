from TwitterAPI import TwitterAPI, TwitterOAuth, TwitterPager

o = TwitterOAuth.read_file(r'C:\apache-tomcat-7.0.34\webapps\HW5\credentials.txt')

o.access_token_key

# Using OAuth1...
twitter = TwitterAPI(o.consumer_key,
                 o.consumer_secret,
                 o.access_token_key,
                 o.access_token_secret)
				 
help(twitter)

# What can we do with this twitter object?
# builtin method `dir` tells us...
dir(twitter)

twitter.auth

# Get help on the `request` method using the builtin method called...`help`
help(twitter.request)

# Let's start by querying the search API
response = twitter.request('search/tweets', {'q': 'big+data'}) 

# What object is returned?
# builtin type method will tell us.
print(type(response))
dir(response)

response.json

response.status_code
# See https://dev.twitter.com/overview/api/response-codes

tweets = [r for r in response]

print('found %d tweets' % len(tweets))

type(tweets)

type(tweets[0])

tweets[0]

help(tweets[0])

tweets[0].keys()

tweets[0]['text']

tweets[0]['created_at']

tweets[0]['text']

tweets[0]['user']

user = tweets[0]['user']
print('screen_name=%s, name=%s, location=%s' % (user['screen_name'], user['name'], user['location']))

# Who follows this person?
# https://dev.twitter.com/docs/api/1.1/get/followers/list
screen_name = user['screen_name']
response  = twitter.request('followers/list', {'screen_name': screen_name, 'count':200})
followers = [follower for follower in response]
        
print('found %d followers for %s' % (len(followers), screen_name))
# See more about paging here: https://dev.twitter.com/docs/working-with-timelines

print(followers[0]['screen_name'])

# Get BestBuyDeals timeline = ''
screen_name = 'BestBuy_Deals'
timeline = [tweet for tweet in twitter.request('statuses/user_timeline',
                                                {'screen_name': screen_name,
                                                 'count': 200})]
print('got %d tweets for user %s' % (len(timeline), screen_name))

# Print time got created.

timeline[3]['created_at']

# Print the text.
print('\n\n\n'.join(t['text'] for t in timeline))

# Count words
from collections import Counter  # This is just a fancy dict mapping from object->int, starting at 0.
counts = Counter()
for tweet in timeline:
    counts.update(tweet['text'].lower().split())
print('found %d unique terms in %d tweets' % (len(counts), len(timeline)))
counts.most_common(10)

import re
for tweet in timeline:
    deal = tweet['text']
    print(deal + '\n')

	
import re
import pymysql

cnx = pymysql.connect(user='root', password='root',
                              host='127.0.0.1',
                              database='Exampledatabase')
cursor = cnx.cursor()

query = ("SELECT ProductName FROM product")
cursor.execute(query)


dealMatchGauranteed=[]
for product in cursor:
    for tweet in timeline:
        deal = (tweet['text'])
        if (len(re.findall('\s'+product[0]+'\s',deal)) >= 1):
            dealMatchGauranteed = dealMatchGauranteed + [deal]
        

# Sanity Test that  we got some deals
dealMatchGauranteed[:5]

dealMatchFile = open(r'C:\apache-tomcat-7.0.34\webapps\HW5\DealMatches.txt', 'w')

for deal in dealMatchGauranteed:
  dealMatchFile.write("%s\n" % deal)

dealMatchFile.close()
		