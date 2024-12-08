<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title></title>
</head>
<body>
FreeMarker模板引擎
<h1>${resource.name}</h1>
<h1>${resource.website}</h1>
<h1>${resource.language}</h1>

<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<div id="app">{{ message }}</div>
<div id="vuejs"><a href="https://vuejs.org/guide/quick-start.html">quick-start.html</a></div>
<div id="vuejs"><a href="https://axios-http.com/docs/example">Axios Example</a></div>

<div id="vuejs">
<p>FirstName: </p>
<input id="firstName" v-model="firstName" placeholder="firstName"/>
<p>LastName: </p>
<input id="lastName" v-model="lastName" placeholder="lastName"/>
</div>

<div>
    <button id="submit">提交</button>
    
    <button id="show">显示</button>
</div>

 
<script>
  const { createApp, ref } = Vue
	
	/*
	createApp({
		setup() {
			const message = ref('Hello YinLiQing!')
			return {
				message
			}
		}
	}).mount('#app');
	*/

    /* get方法的两种写法 */
    axios.get('/greeting',{  /* http://localhost:8080/greeting?name=YinLiQing */
        params:{
            name: 'YinLiQing_OK'
        }
    }).then((result)=>{
		// console.log(result);
		createApp({
			setup() {
				const message = ref(result.data.content)
				return {
					message
				}
			}
		}).mount('#app');
    });

    axios({
        method:'get',
        url:'/greeting', /* 相对于index.ftl */
        params:{
            name: 'YinLiQing'
        }
    }).then(result => {
        console.log(result);
    });

	axios.post('/user', {
		firstName: 'Yin2',
		lastName: 'LiQing2'
	}).then(function (response) {
		console.log(response);
	}).catch(function (error) {
		console.log(error);
	});

</script>


<script>
 
    submit.onclick = function() {
      axios.post('/user', { firstName: firstName.value, lastName: lastName.value})
        .then(response => {
          // 处理响应
          console.log(response.data);
        }).catch(error => {
          // 处理错误
          console.error(error);
        });
    };
    
    const name = ref('Vue.js')
	// 
	show.onclick = function showMessage() {
	  alert(`Hello ${resource.name}!`)
	  // `event` is the native DOM event
	  if (event) {
	    alert(event.target.tagName)
	  }
	}


</script>

</body>
</html>