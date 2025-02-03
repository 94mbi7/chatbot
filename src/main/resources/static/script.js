document.getElementById('chatForm').addEventListener('submit', function(event) {
  event.preventDefault();  // Prevent form submission

  const userInput = document.getElementById('userInput').value;
  document.getElementById('userInput').value = '';  

  // AJAX request
  const xhr = new XMLHttpRequest();
  xhr.open('POST', '/', true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
          const responseDiv = document.getElementById('response');
          responseDiv.innerHTML = xhr.responseText;  // Update response dynamically
      }
  };
  xhr.send(`userInput=${encodeURIComponent(userInput)}`);
});
