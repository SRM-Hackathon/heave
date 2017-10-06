from django.shortcuts import render,get_object_or_404
from django.http import HttpResponse,JsonResponse
from . models import *
from django.views.decorators.csrf import csrf_protect,csrf_exempt

@csrf_exempt
def dashboard(request):
        user=get_object_or_404(user_auth,pk=request.POST['user_id'])
        if( user.user_pwd== request.POST['user_pwd']):
                fname=user.full_name
                return JsonResponse({'fname':fname,'email':user.email})
        else:
                return JsonResponse({"Error":"Login ERROR"})

