from django.shortcuts import render,get_object_or_404
from django.http import HttpResponse,JsonResponse
from . models import *
from django.views.decorators.csrf import csrf_protect,csrf_exempt
from django.core import serializers
import json
@csrf_exempt
def dashboard(request):
	user=get_object_or_404(user_auth,pk=request.POST['user_id'])
	if( user.user_pwd== request.POST['user_pwd']):
		data=serializers.serialize("json",user_auth.objects.filter(pk=user))
		return HttpResponse(data)
	else:
		return JsonResponse({"Error":"Login ERROR"})
@csrf_exempt
def tree_loc(request):
	if request.POST['create']=="No":
		user_id=request.POST['user_id']
		trees=serializers.serialize("json",tree_data.objects.filter(user=user_id))
		return HttpResponse(trees)
	elif request.POST['create']=="Yes":
		user_id=request.POST['user_id']
		tree_num=len(tree_data.objects.filter(user=user_id))+1
		tree_id=str(user_id)+'_'+tree_num
		tree_type=request.POST['tree_type']
		tree_lat=request.POST['tree_loc_lat']
		tree_long=request.POST['tree_loc_long']
		t=tree_data(user_id,tree_id,tree_type,datetime.now(),tree_lat,tree_long)
		t.save()
	else:
		return JsonResponse({"Error":"Create value not set."})
def leaderboard(request):
	user_list=user_auth.objects.all()
	polls={}
	out=[]
	for user in user_list:
		polls[user.user_name]=user.points
	for w in sorted(polls, key=polls.get,reverse=True):
		out.append({w:polls[w]})

	return HttpResponse(out)

