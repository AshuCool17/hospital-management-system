import { Component, OnInit } from '@angular/core';
import { Title, Meta } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title: any;
  
  
  constructor(private titleService: Title, private metaService: Meta) {
    this.loadScripts();
  }
  ngOnInit(): void {
    this.titleService.setTitle(this.title);
    this.metaService.addTags([
      {name: 'viewport', content: 'width=device-width, initial-scale=1'}
    ]);
  }

  loadScripts() {
    const dynamicScripts = [
     'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js',
     'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js',
     'https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js',
     'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'
    ];
    for (let i = 0; i < dynamicScripts.length; i++) {
      const node = document.createElement('script');
      node.src = dynamicScripts[i];
      node.type = 'text/javascript';
      node.async = false;
      node.charset = 'utf-8';
      document.getElementsByTagName('head')[0].appendChild(node);
    }
  }

}
