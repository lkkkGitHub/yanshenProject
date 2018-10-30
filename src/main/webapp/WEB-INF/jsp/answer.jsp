<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%> -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<!--<base href="<%=basePath%>">-->
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>jQuery在线答题考试系统下载 </title>
		<link media="all" href="../../static/css/answer/index_1.css" type="text/css" rel="stylesheet">
	</head>

	<body onload="start();" onunload="alert('The onunload event was triggered');">
		<div class="main">
			<!--nr start-->
			<div class="test_main">
				<div class="nr_left">
					<div class="test">
						<form action="/index" method="post">
							<div class="test_title">
								<font><input name="test_jiaojuan" value="交卷" type="button"></font>
							</div>

							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题，</span><span>合计</span><i class="content_fs">10</i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>

									<li id="qu_0_0">
										<div class="test_content_nr_tt">
											<i>1</i><span>(1分)</span>
											<font>在生产管理信息系统中，下列操作步骤能正确将工单推进流程的是（ ）</font><b class="icon iconfont"></b>
										</div>

										<div class="test_content_nr_main">
											<ul>

												<li class="option">

													<input class="radioOrCheck" name="answer1" id="0_answer_1_option_1" checked="checked" type="radio">

													<label for="0_answer_1_option_1">
                                                A.
                                                <p class="ue" style="display: inline;">在工具栏中点击“workflow”标签</p>
                                            </label>
												</li>

												<li class="option">

													<input class="radioOrCheck" name="answer1" id="0_answer_1_option_2" type="radio">

													<label for="0_answer_1_option_2">
                                                B.
                                                <p class="ue" style="display: inline;">在缺陷单界面中点击“推进流程”按钮</p>
                                            </label>
												</li>

												<li class="option">

													<input class="radioOrCheck" name="answer1" id="0_answer_1_option_3" type="radio">

													<label for="0_answer_1_option_3">
                                                C.
                                                <p class="ue" style="display: inline;">在缺陷单界面中点击“提交”按钮</p>
                                            </label>
												</li>

												<li class="option">

													<input class="radioOrCheck" name="answer1" id="0_answer_1_option_4" type="radio">

													<label for="0_answer_1_option_4">
                                                D.
                                                <p class="ue" style="display: inline;">后台启动流程推进</p>
                                            </label>
												</li>

											</ul>
										</div>
									</li>

								</ul>
							</div>

						</form>
					</div>

				</div>
				<div class="nr_right">
					<div class="nr_rt_main">
						<div class="rt_nr1">
							<div class="rt_nr1_title">
								<h1>
                            <i class="icon iconfont"></i>答题卡
                        </h1>
								<P class="test_time">
									<input type="text" id="timetext" value="00时00分00秒" style="border: none; width: 100px;" readonly><br>
								</P>
							</div>

							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										<li>
											<a href="#qu_0_0" class="hasBeenAnswer">1</a>
										</li>
									</ul>
								</div>
							</div>

						</div>

					</div>
				</div>
			</div>
			<!--nr end-->
			<div class="foot"></div>
		</div>

		<script src="../../static/js/answer/jquery-1.11.3.min.js"></script>
		<script src="../../static/js/answer/jquery.easy-pie-chart.js"></script>
		<!--时间js-->
		<script src="../../static/js/answer/jquery.countdown.js"></script>
		<script>
			window.jQuery(function($) {
				"use strict";

				$('time').countDown({
					with_separators: false
				});
				$('.alt-1').countDown({
					css_class: 'countdown-alt-1'
				});
				$('.alt-2').countDown({
					css_class: 'countdown-alt-2'
				});

			});

			$(function() {
				$('li.option label').click(function() {
					debugger;
					var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
					var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
					// 设置已答题
					if(!cardLi.hasClass('hasBeenAnswer')) {
						cardLi.addClass('hasBeenAnswer');
					}

				});
			});
		</script>

		<script>
			var hour, minute, second; //时 分 秒
			hour = minute = second = 0; //初始化
			var millisecond = 0; //毫秒
			var int;

			function start() //开始
			{
				int = setInterval(timer, 50);
			}

			function timer() //计时
			{
				millisecond = millisecond + 50;
				if(millisecond >= 1000) {
					millisecond = 0;
					second = second + 1;
				}
				if(second >= 60) {
					second = 0;
					minute = minute + 1;
				}

				if(minute >= 60) {
					minute = 0;
					hour = hour + 1;
				}
				document.getElementById('timetext').value = '0' + hour + '时' + minute + '分' + second + '秒';

			}
		</script>

	</body>

</html>