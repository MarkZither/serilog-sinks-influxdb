# serilog-sinks-influxdb
A serilog sink that writes events to InfluxDB.

[![Latest Release](https://img.shields.io/nuget/v/Serilog.Sinks.InfluxDB.Syslog?logo=nuget&label=release&style=for-the-badge)](https://www.nuget.org/packages/Serilog.Sinks.InfluxDB.Syslog)
[![Latest Pre-Release](https://img.shields.io/nuget/vpre/Serilog.Sinks.InfluxDB.Syslog?logo=nuget&color=yellow&label=pre-release&style=for-the-badge)](https://www.nuget.org/packages/Serilog.Sinks.InfluxDB.Syslog/absoluteLatest)
[![Downloads](https://img.shields.io/nuget/dt/Serilog.Sinks.InfluxDB.Syslog?style=for-the-badge&logo=data%3Aimage%2Fpng%3Bbase64%2CiVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAHYcAAB2HAY%2Fl8WUAAAAZdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuMTnU1rJkAAABrUlEQVR4XuXQQW7DMAxE0Rw1R%2BtN3XAjBOpPaptfsgkN8DazIDB8bNu2NCxXguVKsFwJlrJs6KYGS1k2dFODpSwbuqnBUpYN3dRgKcuGbmqwlGVDNzVYyrKhmxosZdnQTQ2WsmzopgZLWTZ0U4OlLBu6qcFSlg3d1GApy4ZuarCUZUM3NVjKsqGbGixl2dBNDZaybOimBktZNnRTg6UsG7qpwVKWDd3UYPnB86VKfl5owx9YflHhCbvHByz%2FcecnHBofsNzhjk84PD5gudOdnnBqfMDygDs84fT4gOVBVz4hNT5gecIVT0iPD1ieNPMJyviAZcKMJ2jjA5ZJI5%2Bgjg9YCkY8QR8fsJSYTxgyPmApMp4wbHzAUpZ5wtDxAcsBzjxh%2BPiA5SBHnjBlfMByoD1PmDY%2BYDnYtydMHR%2BwnICeMH18wHKS9ydcMj5gOVE84bLxAcuVYLkSLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLDvVQ5saLFeC5UqwXAmW69gev7WIMc4gs9idAAAAAElFTkSuQmCC)](https://www.nuget.org/packages/Serilog.Sinks.InfluxDB.Syslog/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=for-the-badge&logo=data%3Aimage%2Fpng%3Bbase64%2CiVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAHYcAAB2HAY%2Fl8WUAAAAZdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuMTCtCgrAAAADB0lEQVR4XtWagXETMRREUwIlUAIlUAodQAl0AJ1AB9BB6AA6gA6MduKbkX%2BevKecNk525jHO3l%2Fp686xlJC70%2Bl0C942vjV%2Bn9FreVQbBc0wWujfRpW8Z78JaIb53hhJ1ygTA80w9PQ36duBMjHQHPCuoQZfutSjeqU1PAJN4E3j2pN7aVKv6pnWcgGawNfGa5N6prVcgGZBn8yvVXZXQbOgPXokXaPMNZwoc41D%2FaHZ8b7hpBrKjnCizIjD%2FaHZ8aPR6%2BeZXqqh7Agnyow43B%2BaZz40qnQ36a6rlsYgnChDLOkPzTN1z%2B9PafU0N3OAcaIMsaQ%2FNBufG1X9JyrtDMr0Y4xwokxlWX%2BPjAYdemhPrWeDvYcPJ8r0LO3v4oszNfivQQuTp2u9qJGKE2V6lvZ38UVj9q3t3oqEE2U2lvfXF4t6qPjTqDUV1fRyhw8nymws768vfOr2NtqOqFY4UUZE%2BusL6VDRX7%2FGzOHDiTIi0t9WMPsUKzNPx4kysf62gmuHir3sPXw4USbWny485ZOc2PsJ7VTro%2F3pwp5DxV7qHq2xa41TrY%2F2J7PfJkaHir3UwwdtU061PtqfTP0CUaYm2v3LxCtoDI2lMWk8p1of7Y8K0jhRJgaaYZwoE0P%2FpFUndZqtP6T4BE2zC5qtP6T4BE2zC5qtPyRN8OvhZUQae3ZBtT7anyb49PA6Ivp5wKnWR%2FvbJkncZXr6wokysf62CXRCWjmJxhqd2JwoE%2BuvTqS37JGJlB39GLzhRJmN5f31gz8XTpSJgWYYJ8rEQDOME2VioBnGiTIx0AzjRJkYaIZxokwMNMM4USYGmmGcKBMDzTBOlImBZhgnysRAM4wTZWKgGcaJMjHQDONEmRhohnGiTAw0wzhRJgaaYZwoEwPNME6UiYFmGCfKxEAzjBNlYqAZxokyMdAMoL%2FO%2BNi4bzjpT1e%2BNFb8V7gFzUXMLHqk%2BM1A8wArFj1S5GagOUly0SMtuxloTnJrUU%2B7QXOSW4t62g2ak9xa1NNu0Jzk1qKednK6%2Bw9roIB8keT%2F3QAAAABJRU5ErkJggg%3D%3D)](LICENSE.md)

| Branch   | Status         |
| -------- | -------------- |
|Main Branch|[![Build status](https://ci.appveyor.com/api/projects/status/uc9y3i52t0dpvxq8/branch/main?svg=true)](https://ci.appveyor.com/project/MarkZither/serilog-sinks-influxdb/branch/main)|

## Benchmarks

BenchmarkDotNet=v0.12.1, OS=Windows 10.0.19042

Intel Core i7-2640M CPU 2.80GHz (Sandy Bridge), 1 CPU, 4 logical and 2 physical cores

.NET Core SDK=5.0.101 
  [Host]     : .NET Core 3.1.9 (CoreCLR 4.700.20.47201, CoreFX 4.700.20.47203), X64 RyuJIT  [AttachedDebugger]   
  DefaultJob : .NET Core 3.1.9 (CoreCLR 4.700.20.47201, CoreFX 4.700.20.47203), X64 RyuJIT


|       Method |    N |     Mean |     Error |    StdDev |
|------------- |----- |---------:|----------:|----------:|
| LogSomething | 1000 | 5.781 us | 0.1832 us | 0.5315 us |
