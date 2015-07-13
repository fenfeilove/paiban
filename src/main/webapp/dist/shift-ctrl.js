'use strict';

paibanControllers.controller('ShiftCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		'$route',
		function($scope, $routeParams, $http, $route) {
			$('#navLink>li').removeClass();
			$('#navLink>li:nth-child(4)').addClass('active');

			$scope.weekno = $routeParams.week - 0;
			$scope.deptno = $routeParams.deptno - 0;

			$http.get("department").success(function(data) {
				$scope.allDepartment = data;
			});

			var d = new Date();
			d.setDate(new Date().getDate() + $routeParams.week * 7);
			var w = d.getDay();
			var n = (w == 0 ? 7 : w) - 1;
			d.setDate(d.getDate() - n);
			$scope.week = [];
			for (var i = 0; i < 7; i++) {
				$scope.week.push(JSON.parse(JSON.stringify(d)));
				d.setDate(d.getDate() + 1);
			}
			function loadSft() {

				$http.get(
						"chaxun2?weekno=" + $routeParams.week + "&deptno="
								+ $routeParams.deptno).success(function(data) {
				 data.forEach(function (tb) {
		                for (var i in $scope.allDepartment) {
		                    if ($scope.allDepartment[i].deptno == tb.emp.deptno) {
		                        tb.emp.deptName = $scope.allDepartment[i].dname;
		                        break;
		                    }
		                }
		            });
					$scope.sft = data;
				});

			}
			loadSft();

			$scope.onChange = function(empno, clazzid, index) {
				$http.post("chaxun2/update", {
					empno : empno,
					classid : clazzid,
					date : $scope.week[index]
				}).success(function() {
					loadSft();
					alert("update ok");
			
				}).error(function() {
					alert("failed");
				});

			}

			$scope.export = function() {
				var w = $scope.week;
				var data = [ [ '姓名', '部门',w[0].substr(0, 10), w[1].substr(0, 10),
						w[2].substr(0, 10), w[3].substr(0, 10),
						w[4].substr(0, 10), w[5].substr(0, 10),
						w[6].substr(0, 10) ] ];

				$scope.sft.forEach(function(tb) {
					data.push([ tb.emp.ename,tb.emp.deptName, kkk(tb.a[0]), kkk(tb.a[1]),
							kkk(tb.a[2]), kkk(tb.a[3]), kkk(tb.a[4]),
							kkk(tb.a[5]), kkk(tb.a[6]) ]);
				});

				function kkk(i) {
					switch (i) {
					case 0:
						return '';
					case 1:
						return '白班';
					case 2:
						return '夜班';
					case 3:
						return '正常班';
					case 4:
						return '休息';
					}
				}

				$scope.colors = [ '', 'green', 'grey', 'yellow', '' ];

				var ranges = [];

				var ws_name = "SheetJS";
				console.log(data);
				var wb = new Workbook(), ws = sheet_from_array_of_arrays(data);
				/* add ranges to worksheet */
				ws['!merges'] = ranges;
				/* add worksheet to workbook */
				wb.SheetNames.push(ws_name);
				wb.Sheets[ws_name] = ws;

				var wbout = XLSX.write(wb, {
					bookType : 'xlsx',
					bookSST : false,
					type : 'binary'
				});

				saveAs(new Blob([ s2ab(wbout) ], {
					type : "application/octet-stream"
				}), "paiban.xlsx")
			}

		} ]);
